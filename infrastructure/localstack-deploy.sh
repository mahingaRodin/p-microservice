#!/bin/bash
set -e #stops the script if any command fails

# 1. Delete the stuck stack
aws --endpoint-url=http://localhost:4566 cloudformation delete-stack \
    --stack-name patient-management

# 2. Wait a few seconds
sleep 5

# 3. Deploy fresh
aws --endpoint-url=http://localhost:4566 cloudformation deploy \
    --stack-name patient-management \
    --template-file "./cdk.out/localstack.template.json"

## 4. Check what failed (if it fails again)
#aws --endpoint-url=http://localhost:4566 cloudformation de scribe-stack-events \
#    --stack-name patient-management \
#    --query 'StackEvents[?contains(ResourceStatus, `FAILED`)]' \
#    --output table

aws --endpoint-url=http://localhost:4566 cloudformation describe-stack-events \
    --stack-name patient-management \
    --query 'StackEvents[?contains(ResourceStatus, `FAILED`)]' \
    --output json