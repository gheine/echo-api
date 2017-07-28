#!/usr/bin/env bash

set -ex

BRANCH_NAME=$(git rev-parse --abbrev-ref HEAD)

fly set-pipeline \
    -t $TARGET -p echo-api_$BRANCH_NAME \
    -c ./deploy/rogue/pipelines/pipeline.yml \
    --load-vars-from ./deploy/rogue/pipelines/config.yml \
    --load-vars-from $SECRETS_FILE \
    -v app-branch=$BRANCH_NAME

fly pause-job -t $TARGET -j echo-api_$BRANCH_NAME/test

fly unpause-pipeline -t $TARGET -p echo-api_$BRANCH_NAME


echo "Done!"
