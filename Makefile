.PHONY: help
.DEFAULT_GOAL := help

help:
	@echo "---------------------------------------------------------------------------------------"
	@echo ""
	@echo "				CLI"
	@echo ""
	@echo "---------------------------------------------------------------------------------------"
	@echo ""
	@awk 'BEGIN {FS = ":.*##"; printf "Usage: make \033[36m<target>\033[0m\n"} /^[a-zA-Z_-]+:.*?##/ { printf "  \033[36m%-25s\033[0m %s\n", $$1, $$2 } /^##@/ { printf "\n\033[1m%s\033[0m\n", substr($$0, 5) } ' $(MAKEFILE_LIST)

##@ Development

build: ## Build the project
	@scripts/build.sh

full-build: ## Full build the project
	@read -p "Sonar Login: " passwd; \
	CI_SECURE_ENV_VARS=true \
	SONAR_ORGANIZATION=bhuwanupadhyay \
	SONAR_HOST=https://sonarcloud.io \
	SONAR_LOGIN=$$passwd \
	./scripts/build.sh

##@ Releasing

version: ## Get the current version
	@scripts/before_ci.sh
