#!/bin/bash

BEFORE_CI_SCRIPT="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)/before_ci.sh"
# shellcheck source=scripts/before_ci.sh
source "${BEFORE_CI_SCRIPT}"

# run the ITs if we have an ENV_VARS are set
if [ "${CI_SECURE_ENV_VARS}" = true ]; then
  RUN_ITS=true
fi
RUN_ITS=${RUN_ITS:-false}

if [ "$BRANCH" = "$SNAPSHOT_BRANCH" ] && [ "$PULL_REQUEST" = false ] && [ "${RUN_ITS}" = true ] && [ ! "${IS_RELEASE}" = true ]; then
  DEPLOY=true
fi
DEPLOY=${DEPLOY:-false}

SONAR_BRANCH=${BRANCH}

if [ "${BRANCH}" = "$SNAPSHOT_BRANCH" ]; then
  SONAR_BRANCH=""
fi

# all the prep is done, lets run the build!
MVN_CMD="./mvnw -s settings.xml -B -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn -V"
