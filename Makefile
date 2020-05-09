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
pull: ## Pull latest changes of the project branch
	git submodule update --init --recursive && git submodule update --remote && git pull

docs: ## Build the project documentation
	IS_DOCS=true \
	./cicd/ci/build.sh

build: ## Build the project
	./cicd/ci/build.sh

full-build: ## Full build the project
	@read -p "Sonar Login: " passwd; \
	CI_SECURE_ENV_VARS=true \
	SONAR_ORGANIZATION=bhuwanupadhyay \
	SONAR_HOST=https://sonarcloud.io \
	SONAR_LOGIN=$$passwd \
	./cicd/ci/build.sh

##@ Releasing

version: ## Get the current version
	./cicd/ci/before_ci.sh

##@ Deploying

registry: ## Run schema registry
	./mvnw spring-boot:run -f schema-registry/pom.xml
order-service: ## Run order service
	./mvnw clean spring-boot:run -f order-service/pom.xml
payment-service: ## Run payment service
	./mvnw clean spring-boot:run -f payment-service/pom.xml
