# Edge File Transfer
Edge File Transfer gives you a utility to monitor new files copied to a local directory, it, then, breaks those files in chunks of 512KB and forward to EventHub service.

## Main Features

1. Files will be collected from a pre-defined directory, ordered by pre-defined file's attribute
2. Pre-defined directory is configurable and can be adjusted(e.g if old files exist in the new directory, they will still be sent).  When the directory is changed, it is considered to start a new collect/upload batch
3. The interval to check for new file will be 10 seconds by default and can be adjusted
4. There will be configuration for deleting/keeping file after sending successfully
5. File should not be sent duplicated
6. If application fails to send file, it will retry it forever until the file is delivered
7. If application is disconnected, it will retry with progressive back-off time
8. If file is deleted while being uploaded, application will move to the next file in queue
9. The adapter and river can be upgraded(non-docker)
10. Files will be sent to EventHub

## Technology

### Platform Services:

- Predix EventHub

### Programming Languages:

- Java 8

<br>

## Application Deployment

### Application Dependencies

1. [Edge Eventhub Publisher](../edge-eventhub-publisher-grpc)
2. [Predix Store Forward](../predix-store-forward)

Please follow steps in above links to build maven dependency apps before continuing next step for this Edge File Transfer app.

#### Predix Services:
|Service |Description |
| ------------- | :----- | 
|Predix EventHub |Predix EventHub service for message publish/subscribe |

#### Environment:
|Tools/Framework | Version | Notes |
| ------------- | :----- | :----- |
| Java |8.x | |
| Spring Framework |4.x | |
| GitHub | | |
| Maven |3.3.9 |  |
| CloudFoundry CLI |6.29.0+ |  https://docs.cloudfoundry.org/cf-cli/install-go-cli.html |
| UAAC |3.6.0 | https://github.com/cloudfoundry/cf-uaac |
| Predix Machine |17.1.3 | Predix Machine container| 

## Build & Deploy App in docker:

1. Check out source code:
```
    git clone https://github.com/PredixSolutions/reusablecomponents/tree/edge-file-transfer-master/reusablecomponents/predix-edge-file-transfer/predix-metadata-extractor

    cd reusablecomponents/reusablecomponents/predix-edge-file-transfer/predix-metadata-extractor/
```
2. Build and create docker images to docker's cache:
```
mvn clean package docker:build
```
3. Check docker images:
```
docker images
```
=> You can see docker image named "edge-file-transfer" is loaded into docker's cache.

4. Run Docker container:

    Following steps will be run in two approaches. You can choose either way to execute docker container.

    4.1 By Native docker command:

    4.1.1 Access to file [docker.env](./docker.env) and change environment variables to appropriate values:


    ```
    DB_FILE_PATH: file path of H2 database.
    H2_USERNAME: H2 username
    SCHEDULER_TIME: Scheduler time to scan uploaded folder.
    SCHEDULER_RESET_DB_TIME: cron expression for clean old metadata in database.
    EDGE_CONFIG:<path_of_folder_contain_edge_config_file>/edge-config.json
    ````

    Sample docker.env:

    ```
    DB_FILE_PATH=./store-forward
    H2_USERNAME=sa
    SCHEDULER_TIME=10000
    SCHEDULER_RESET_DB_TIME=0 1 0 * * ?
    SPRING_PROFILE_ACTIVE=docker
    EDGE_CONFIG=/Users/localuser/edge-config/edge-config.json
    ```

    4.1.2 Run docker container:

    ```
    docker run -d -p <PORT>:8083 -v <path_of_files_directory>:<path_of_files_directory>  -v <path_of_folder_contain_edge_config_file>:<path_of_folder_contain_edge_config_file> --env-file docker.env --name edge-file-transfer -t edge-file-transfer
    ```
    ```
    Ex: docker run -d  -p 9093:8083 -v /Users/localuser/upload:/Users/localuser/upload -v /Users/localuser/edge-config:/Users/localuser/edge-config --env-file docker.env --name edge-file-transfer -t edge-file-transfer
    ```

    Note:
    ```
    + <PORT>: exposed port from docker container
    + <path_of_files_directory>: file_path value in edge-config.json 
    + <path_of_folder_contain_edge_config_file>: path of folder that contains edge-config.json

    ```

    Sample edge-config.json:
    ```
    {
        "file_pattern": ".*\\.txt",
        "file_path": "/Users/localuser/upload",
        "order_type": "name",
        "is_delete": true,
        "eventHub_host": "event-hub-aws-usw02.data-services.predix.io",
        "eventHub_authURL": "https://da15-4b5c-b5b3-e4a80ad99bdb.predix-uaa.run.aws-usw02-pr.ice.predix.io/oauth/token",
        "eventHub_zoneId": "096e8edb-2a4a-448c-9df5",
        "client_id": "test-client",
        "client_secret": "test-secret"

    }
    ```

    4.2 By docker-compose command:

    4.2.1 Access to file [docker.env](./docker.env) and change environment variables to appropriate values:
    ```
    DB_FILE_PATH: file path of H2 database.
    H2_USERNAME: H2 username
    SCHEDULER_TIME: Scheduler time to scan uploaded folder.
    SCHEDULER_RESET_DB_TIME: cron expression for clean old metadata in the database.
    EDGE_CONFIG:<path_of_folder_contain_edge_config_file>/edge-config.json
    ````

    4.2.2 Access to file [docker-compose.yml](./docker-compose.yml) and change  variables to appropriate values:
    
    ```
    + <PORT>: exposed port from docker container
    + <path_of_files_directory>: file_path value in edge-config.json 
    + <path_of_folder_contain_edge_config_file>: path of folder that contains edge-config.json

    ```

    Sample docker-compose.yml file:
    ```
    version: '2'
      services:
        local:
        container_name: edge-file-transfer
        ports:
            - "9093:8083"
        image: "edge-file-transfer"
        env_file:
            - docker.env
        volumes:
            - /Users/localuser/edge-config:/Users/localuser/edge-config
            - /Users/localuser/upload:/Users/localuser/upload

     ```

    4.2.3 Run docker-compose command:

    Please run command below:

    ```
    docker-compose.yml up -d
    ```
