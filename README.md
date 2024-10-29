## Run 

```
java -jar .\docql-0.0.1-SNAPSHOT.jar --input-file=".\docql\src\test\resources\example-mutation.json"
{
  "operationName" : "deleteTasks",
  "variables" : {
    "taskIds" : "X"
  },
  "query" : "mutation deleteTasks($taskIds: [Long]!) {\n artisan {\n __typename\n deleteTasks(request: {ids: $taskIds})  {\n __typename\n success\n }\n }\n }\n"
}
```