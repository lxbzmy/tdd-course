#  一组仿真REST API

## INFO

    GET http://mock-api.com/k7gPXAgl.mock/spock/hello 
    
    {"hello":"world"}

## LOGIN

    POST http://mock-api.com/k7gPXAgl.mock/spock/login
    Content-Type: application/x-www-form-urlencoded
    username=root&password=root
    
    {"success":true,"username":"root"}


## SEARCH

    GET http://mock-api.com/k7gPXAgl.mock/spock/product/_search
    
    {
      "page":1,
      "content":[{"name":"张三"},{"name":"李四"}],
      "total":4
    }
    
## SEARCH 2

    GET http://mock-api.com/k7gPXAgl.mock/spock/product/_search?page=2
    {
    "page":2,
    "content":[{"name":"王五"},{"name":"马六"}],
    "total":4
    }    

## LOGOUT

    POST http://mock-api.com/k7gPXAgl.mock/spock/logout
    
    {"success":true}

## 401

    GET http://mock-api.com/k7gPXAgl.mock/spock/product/_search?page=3
    
    HTTP 401     