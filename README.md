# EJM TASK

[TOC]

------



## 1. 실행 방법

- 로컬 실행 : `./gradlew bootRun --args='--spring.profiles.active=local`
  - `application-local.yml` 에서 JDBC Connection 수정 필요
    - `spring.datasource.url`
    - `spring.datasource.username`
    - `spring.datasource.password`
- Controller Layer Unit Test 실행 : `./gradlew test`
  - standalone한 mysql JDBC Connection을 사용하기 위해 testcontainers를 사용하므로 실행 PC에서 Docker 설치 필요
- build : `./gradlew build`



## 2. API Documentation 정보



SSR 페이지 (로컬 실행 필요)

- Swagger-UI OAS 3 : http://localhost:9000/swagger
- Spring REST Docs HTML : http://localhost:9000/docs/index.html



로컬 파일

- Swagger-UI OAS 3 Json : src/main/resources/static/docs/common-code-open-api-3.0.1.json
- Postman API Collection : src/main/resources/static/docs/common-code-postman-collection.json
- Spring REST Docs HTML : src/main/resources/static/docs/index.html



------



## 3. [Common Code API](http://localhost:9000/docs/index.html#Common-Code-API)

### [공통 코드 리스트 조회 API](http://localhost:9000/docs/index.html#_공통_코드_리스트_조회_api)

#### [Curl request](http://localhost:9000/docs/index.html#_공통_코드_리스트_조회_api_curl_request)

```bash
$ curl 'http://localhost:9000/code/list' -i -X POST \
    -H 'Content-Type: application/json;charset=UTF-8' \
    -d '{
  "pageNo" : 0,
  "pageSize" : 10,
  "value" : "",
  "name" : "",
  "groupUuid" : "",
  "groupNm" : ""
}'
```

#### [HTTP request](http://localhost:9000/docs/index.html#_공통_코드_리스트_조회_api_http_request)

```http
POST /code/list HTTP/1.1
Content-Type: application/json;charset=UTF-8
Content-Length: 106
Host: localhost:9000

{
  "pageNo" : 0,
  "pageSize" : 10,
  "value" : "",
  "name" : "",
  "groupUuid" : "",
  "groupNm" : ""
}
```

#### [HTTP response](http://localhost:9000/docs/index.html#_공통_코드_리스트_조회_api_http_response)

```http
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
Content-Length: 2972

{
  "message" : "SUCCESS",
  "result" : {
    "content" : [ {
      "uuid" : "83cd77de-f325-4e2f-9d82-cbb42f2b1f23",
      "value" : "043b8bdf-8ab7-48e1-a66c-1414f5bda168",
      "name" : "043b8bdf-8ab7-48e1-a66c-1414f5bda168_10",
      "groupName" : "c9747eef-382f-4537-918d-cddd95675850_6"
    }, {
      "uuid" : "907be4b2-0443-41c7-b66c-5fce9902c09a",
      "value" : "04eba1c1-d62a-48f9-a144-d321c06a7476",
      "name" : "04eba1c1-d62a-48f9-a144-d321c06a7476_93",
      "groupName" : "45cb75d8-17f5-4783-aad9-b5c55273d383_22"
    }, {
      "uuid" : "247f571b-dc9c-4e1f-b7bb-51abc8a0ad24",
      "value" : "053fd8f9-7222-436c-bb10-630b42c3a1ee",
      "name" : "053fd8f9-7222-436c-bb10-630b42c3a1ee_2",
      "groupName" : "3939703b-84f0-4eb5-a6e4-db7ff64e3683_10"
    }, {
      "uuid" : "521ad2d2-cce0-4b99-8744-acc6642ab2e7",
      "value" : "05c4cd7a-9033-4755-b660-b20d64163dc5",
      "name" : "05c4cd7a-9033-4755-b660-b20d64163dc5_91",
      "groupName" : "e4c13bd1-6b30-451b-9398-e3d5e99ea3d3_21"
    }, {
      "uuid" : "f37fb3c7-1f09-4c38-886c-515549ade9ed",
      "value" : "05d136ae-e1c0-45b0-ad61-c0d8c74bb6bf",
      "name" : "05d136ae-e1c0-45b0-ad61-c0d8c74bb6bf_74",
      "groupName" : "526cce7a-f24e-45c7-b390-fcf61e0c3b48_23"
    }, {
      "uuid" : "f96fe661-02d6-4d8d-a383-48a71234a29f",
      "value" : "09198ad1-7f24-4dfe-b92c-6e296fca4234",
      "name" : "09198ad1-7f24-4dfe-b92c-6e296fca4234_43",
      "groupName" : "e4c13bd1-6b30-451b-9398-e3d5e99ea3d3_21"
    }, {
      "uuid" : "e0510b89-3c48-48d6-ad5e-5cfd3617c861",
      "value" : "0a9cf881-1243-4fc0-bdf2-2a18f012ed65",
      "name" : "0a9cf881-1243-4fc0-bdf2-2a18f012ed65_82",
      "groupName" : "2c137eba-937f-4791-a288-711d9860be0e_12"
    }, {
      "uuid" : "ac1810ed-288e-4c05-bde3-0ee9ed32d03c",
      "value" : "0ddea9a0-ac31-4503-9b04-60e7256ca119",
      "name" : "0ddea9a0-ac31-4503-9b04-60e7256ca119_0",
      "groupName" : "98691ac6-e010-4f42-8b35-efbc8b44cfcc_15"
    }, {
      "uuid" : "d200ae56-cdd5-4341-8d5e-7990ebdcb7e0",
      "value" : "0decc9bb-413a-4dfc-a702-a9f0e0d1170b",
      "name" : "0decc9bb-413a-4dfc-a702-a9f0e0d1170b_99",
      "groupName" : "32bf99b8-cbb0-40ba-afeb-c127f6f38b04_1"
    }, {
      "uuid" : "668e3c3b-756a-4a67-bbf8-47e8c2a1e8fb",
      "value" : "0e01a829-1865-4d37-b798-e509ebc6b0d8",
      "name" : "0e01a829-1865-4d37-b798-e509ebc6b0d8_90",
      "groupName" : "1456fe2a-4f34-4195-8e13-7ab05713ac19_11"
    } ],
    "pageable" : {
      "sort" : {
        "empty" : false,
        "sorted" : true,
        "unsorted" : false
      },
      "offset" : 0,
      "pageNumber" : 0,
      "pageSize" : 10,
      "paged" : true,
      "unpaged" : false
    },
    "last" : false,
    "totalPages" : 10,
    "totalElements" : 100,
    "number" : 0,
    "first" : true,
    "sort" : {
      "empty" : false,
      "sorted" : true,
      "unsorted" : false
    },
    "size" : 10,
    "numberOfElements" : 10,
    "empty" : false
  }
}
```

#### [Request fields](http://localhost:9000/docs/index.html#_공통_코드_리스트_조회_api_request_fields)

| Path        | Type     | Description      |
| :---------- | :------- | :--------------- |
| `pageNo`    | `Number` | 페이지 번호      |
| `pageSize`  | `Number` | 페이지 당 크기   |
| `value`     | `String` | 코드 값          |
| `name`      | `String` | 코드명           |
| `groupUuid` | `String` | 코드 그룹 식별자 |
| `groupNm`   | `String` | 코드 그룹 이름   |

#### [Response fields](http://localhost:9000/docs/index.html#_공통_코드_리스트_조회_api_response_fields)

| Path                            | Type      | Description                  |
| :------------------------------ | :-------- | :--------------------------- |
| `message`                       | `String`  | 시스템 메시지                |
| `result.content[]`              | `Array`   | 오브젝트                     |
| `result.content[].uuid`         | `String`  | 고유번호                     |
| `result.content[].value`        | `String`  | 코드 값                      |
| `result.content[].name`         | `String`  | 코드명                       |
| `result.content[].groupName`    | `String`  | 코드 그룹 이름               |
| `result.pageable`               | `Object`  | 페이징 오브젝트              |
| `result.pageable.offset`        | `Number`  | offset                       |
| `result.pageable.pageNumber`    | `Number`  | 페이지 번호 (0부터 시작)     |
| `result.pageable.pageSize`      | `Number`  | 요청한 페이지 당 크기        |
| `result.pageable.paged`         | `Boolean` | 페이징 여부                  |
| `result.pageable.unpaged`       | `Boolean` | 미 페이징 여부               |
| `result.pageable.sort`          | `Object`  | 정렬 정보                    |
| `result.pageable.sort.empty`    | `Boolean` | 정렬 정보 미존재 여부        |
| `result.pageable.sort.unsorted` | `Boolean` | 미정렬 여부                  |
| `result.pageable.sort.sorted`   | `Boolean` | 정렬 여부                    |
| `result.last`                   | `Boolean` | 마지막 페이지 여부           |
| `result.totalPages`             | `Number`  | 페이지 갯수                  |
| `result.totalElements`          | `Number`  | 총 요소 갯수                 |
| `result.first`                  | `Boolean` | 첫 페이지 여부               |
| `result.size`                   | `Number`  | 페이지 당 크기               |
| `result.number`                 | `Number`  | 페이지 번호 (0부터 시작)     |
| `result.sort.empty`             | `Boolean` | 정렬 정보 미존재 여부        |
| `result.sort.unsorted`          | `Boolean` | 미정렬 여부                  |
| `result.sort.sorted`            | `Boolean` | 정렬 여부                    |
| `result.numberOfElements`       | `Number`  | 현재 페이지 요소 갯수        |
| `result.empty`                  | `Boolean` | 현재 페이지 요소 미존재 여부 |

### [공통 코드 상세 조회 API](http://localhost:9000/docs/index.html#_공통_코드_상세_조회_api)

#### [Curl request](http://localhost:9000/docs/index.html#_공통_코드_상세_조회_api_curl_request)

```bash
$ curl 'http://localhost:9000/code/44c9ac67-509e-40b3-a365-b1e166811579' -i -X GET
```

#### [HTTP request](http://localhost:9000/docs/index.html#_공통_코드_상세_조회_api_http_request)

```http
GET /code/44c9ac67-509e-40b3-a365-b1e166811579 HTTP/1.1
Host: localhost:9000
```

#### [HTTP response](http://localhost:9000/docs/index.html#_공통_코드_상세_조회_api_http_response)

```http
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
Content-Length: 533

{
  "message" : "SUCCESS",
  "result" : {
    "uuid" : "44c9ac67-509e-40b3-a365-b1e166811579",
    "value" : "2cf8a2ec-aa19-4466-9aaa-fc88ac0e52d2",
    "name" : "2cf8a2ec-aa19-4466-9aaa-fc88ac0e52d2_0",
    "groupName" : "060564b7-20e7-41c4-84ad-8783a28e1a85_5",
    "description" : "2cf8a2ec-aa19-4466-9aaa-fc88ac0e52d2",
    "groupUuid" : "7ffb6d80-8ecf-41b9-9b14-2612231d2a58",
    "groupDescription" : "060564b7-20e7-41c4-84ad-8783a28e1a85",
    "createdAt" : "2023-06-29 19:05:04",
    "updatedAt" : "2023-06-29 19:05:04"
  }
}
```

#### [Path parameters](http://localhost:9000/docs/index.html#_공통_코드_상세_조회_api_path_parameters)

| Parameter | Description     |
| :-------- | :-------------- |
| `uuid`    | 공통코드 식별자 |

#### [Response fields](http://localhost:9000/docs/index.html#_공통_코드_상세_조회_api_response_fields)

| Path                      | Type     | Description          |
| :------------------------ | :------- | :------------------- |
| `message`                 | `String` | 시스템 메시지        |
| `result`                  | `Object` | 오브젝트             |
| `result.uuid`             | `String` | 공통코드 식별자      |
| `result.value`            | `String` | 공통코드 값          |
| `result.name`             | `String` | 공통코드 이름        |
| `result.groupName`        | `String` | 공통코드 그룹 이름   |
| `result.description`      | `String` | 공통코드 설명        |
| `result.groupUuid`        | `String` | 공통코드 그룹 식별자 |
| `result.groupDescription` | `String` | 공통코드 그룹 설명   |
| `result.createdAt`        | `String` | 생성일               |
| `result.updatedAt`        | `String` | 수정일               |

### [공통 코드 생성 API](http://localhost:9000/docs/index.html#_공통_코드_생성_api)

#### [Curl request](http://localhost:9000/docs/index.html#_공통_코드_생성_api_curl_request)

```bash
$ curl 'http://localhost:9000/code' -i -X POST \
    -H 'Content-Type: application/json;charset=UTF-8' \
    -d '{
  "value" : "A10",
  "name" : "대여",
  "description" : "물품 대여 상태를 나타내는 코드",
  "groupUuid" : "e413d19d-9e12-4fbc-bed1-7f6e72ffefb1"
}'
```

#### [HTTP request](http://localhost:9000/docs/index.html#_공통_코드_생성_api_http_request)

```http
POST /code HTTP/1.1
Content-Type: application/json;charset=UTF-8
Content-Length: 163
Host: localhost:9000

{
  "value" : "A10",
  "name" : "대여",
  "description" : "물품 대여 상태를 나타내는 코드",
  "groupUuid" : "e413d19d-9e12-4fbc-bed1-7f6e72ffefb1"
}
```

#### [HTTP response](http://localhost:9000/docs/index.html#_공통_코드_생성_api_http_response)

```http
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
Content-Length: 27

{
  "message" : "SUCCESS"
}
```

#### [Request fields](http://localhost:9000/docs/index.html#_공통_코드_생성_api_request_fields)

| Path          | Type     | Description          |
| :------------ | :------- | :------------------- |
| `value`       | `String` | 공통코드 값          |
| `name`        | `String` | 공통코드 명          |
| `description` | `String` | 공통코드 설명        |
| `groupUuid`   | `String` | 공통코드 그룹 식별자 |

#### [Response fields](http://localhost:9000/docs/index.html#_공통_코드_생성_api_response_fields)

| Path      | Type     | Description   |
| :-------- | :------- | :------------ |
| `message` | `String` | 시스템 메시지 |

### [공통 코드 수정 API](http://localhost:9000/docs/index.html#_공통_코드_수정_api)

#### [Curl request](http://localhost:9000/docs/index.html#_공통_코드_수정_api_curl_request)

```bash
$ curl 'http://localhost:9000/code' -i -X PATCH \
    -H 'Content-Type: application/json;charset=UTF-8' \
    -d '{
  "uuid" : "49940dd5-7254-49d3-8880-00c07e84996a",
  "value" : "A10",
  "name" : null,
  "description" : null,
  "groupUuid" : null
}'
```

#### [HTTP request](http://localhost:9000/docs/index.html#_공통_코드_수정_api_http_request)

```http
PATCH /code HTTP/1.1
Content-Type: application/json;charset=UTF-8
Content-Length: 135
Host: localhost:9000

{
  "uuid" : "49940dd5-7254-49d3-8880-00c07e84996a",
  "value" : "A10",
  "name" : null,
  "description" : null,
  "groupUuid" : null
}
```

#### [HTTP response](http://localhost:9000/docs/index.html#_공통_코드_수정_api_http_response)

```http
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
Content-Length: 27

{
  "message" : "SUCCESS"
}
```

#### [Request fields](http://localhost:9000/docs/index.html#_공통_코드_수정_api_request_fields)

| Path          | Type     | Description          |
| :------------ | :------- | :------------------- |
| `uuid`        | `String` | 공통코드 식별자      |
| `value`       | `String` | 공통코드 값          |
| `name`        | `Null`   | 공통코드 명          |
| `description` | `Null`   | 공통코드 설명        |
| `groupUuid`   | `Null`   | 공통코드 그룹 식별자 |

#### [Response fields](http://localhost:9000/docs/index.html#_공통_코드_수정_api_response_fields)

| Path      | Type     | Description   |
| :-------- | :------- | :------------ |
| `message` | `String` | 시스템 메시지 |

### [공통 코드 삭제 API](http://localhost:9000/docs/index.html#_공통_코드_삭제_api)

#### [Curl request](http://localhost:9000/docs/index.html#_공통_코드_삭제_api_curl_request)

```bash
$ curl 'http://localhost:9000/code/fe54ccbd-378a-453c-adfc-a8b9efc7ecc4' -i -X DELETE
```

#### [HTTP request](http://localhost:9000/docs/index.html#_공통_코드_삭제_api_http_request)

```http
DELETE /code/fe54ccbd-378a-453c-adfc-a8b9efc7ecc4 HTTP/1.1
Host: localhost:9000
```

#### [HTTP response](http://localhost:9000/docs/index.html#_공통_코드_삭제_api_http_response)

```http
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
Content-Length: 27

{
  "message" : "SUCCESS"
}
```

#### [Path parameters](http://localhost:9000/docs/index.html#_공통_코드_삭제_api_path_parameters)

| Parameter | Description     |
| :-------- | :-------------- |
| `uuid`    | 공통코드 식별자 |

#### [Response fields](http://localhost:9000/docs/index.html#_공통_코드_삭제_api_response_fields)

| Path      | Type     | Description   |
| :-------- | :------- | :------------ |
| `message` | `String` | 시스템 메시지 |



------



## 4. [Common Code Group API](http://localhost:9000/docs/index.html#Common-Code-Group-API)

### [공통 코드 그룹 리스트 조회 API](http://localhost:9000/docs/index.html#_공통_코드_그룹_리스트_조회_api)

#### [Curl request](http://localhost:9000/docs/index.html#_공통_코드_그룹_리스트_조회_api_curl_request)

```bash
$ curl 'http://localhost:9000/code/group/list' -i -X POST \
    -H 'Content-Type: application/json;charset=UTF-8' \
    -d '{
  "pageNo" : 0,
  "pageSize" : 10,
  "name" : ""
}'
```

#### [HTTP request](http://localhost:9000/docs/index.html#_공통_코드_그룹_리스트_조회_api_http_request)

```http
POST /code/group/list HTTP/1.1
Content-Type: application/json;charset=UTF-8
Content-Length: 52
Host: localhost:9000

{
  "pageNo" : 0,
  "pageSize" : 10,
  "name" : ""
}
```

#### [HTTP response](http://localhost:9000/docs/index.html#_공통_코드_그룹_리스트_조회_api_http_response)

```http
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
Content-Length: 1781

{
  "message" : "SUCCESS",
  "result" : {
    "content" : [ {
      "uuid" : "12574341-9cdf-4770-9966-3216a8c899b1",
      "name" : "1100499a-445e-47e2-bc4b-613c2edaa2f0_5"
    }, {
      "uuid" : "66bfe2a7-44f8-4530-8ac6-eab338d747e4",
      "name" : "1490bb9c-058a-48c4-b1fa-6615a79af4a1_11"
    }, {
      "uuid" : "bcc8d6f0-e634-4b9d-91bb-80d3fa322566",
      "name" : "1747f645-e507-4525-8a8c-31f0e19a407f_21"
    }, {
      "uuid" : "63c16acb-c674-4c01-9333-4190de85ee11",
      "name" : "251c7d77-56fc-4647-9b8b-b021e84fc5af_16"
    }, {
      "uuid" : "e570eb14-4ced-4403-9e16-e007d12811d0",
      "name" : "25c3afa6-8f25-4763-bc7f-bd63a518081c_23"
    }, {
      "uuid" : "6b29b4cd-b0b7-4c6b-be13-6d2fa82aae7c",
      "name" : "32fe75f9-daec-4deb-99df-0165247189a7_12"
    }, {
      "uuid" : "664d884c-52ee-4744-a984-f78f4c139049",
      "name" : "34bfb31c-e58e-4f52-9cbf-2482f0daa65c_7"
    }, {
      "uuid" : "d5511690-7a0e-49fe-bb39-0abf91afcc81",
      "name" : "445c19a2-4c1d-4bfe-a96b-c04fb4d18a30_14"
    }, {
      "uuid" : "cf7873f2-dfc0-493f-a4f8-61fe600f62bf",
      "name" : "45df356d-7195-493c-b838-a1007dea8f98_19"
    }, {
      "uuid" : "0f4e405b-9451-4710-a47e-21f12f1549c8",
      "name" : "47e56742-32fe-4ce7-9030-a88f325abe7f_6"
    } ],
    "pageable" : {
      "sort" : {
        "empty" : false,
        "sorted" : true,
        "unsorted" : false
      },
      "offset" : 0,
      "pageNumber" : 0,
      "pageSize" : 10,
      "paged" : true,
      "unpaged" : false
    },
    "last" : false,
    "totalPages" : 3,
    "totalElements" : 25,
    "number" : 0,
    "first" : true,
    "sort" : {
      "empty" : false,
      "sorted" : true,
      "unsorted" : false
    },
    "size" : 10,
    "numberOfElements" : 10,
    "empty" : false
  }
}
```

#### [Request fields](http://localhost:9000/docs/index.html#_공통_코드_그룹_리스트_조회_api_request_fields)

| Path       | Type     | Description      |
| :--------- | :------- | :--------------- |
| `pageNo`   | `Number` | 페이지 번호      |
| `pageSize` | `Number` | 페이지 당 크기   |
| `name`     | `String` | 공통 코드 그룹명 |

#### [Response fields](http://localhost:9000/docs/index.html#_공통_코드_그룹_리스트_조회_api_response_fields)

| Path                            | Type      | Description                  |
| :------------------------------ | :-------- | :--------------------------- |
| `message`                       | `String`  | 시스템 메시지                |
| `result.content[]`              | `Array`   | 오브젝트                     |
| `result.content[].uuid`         | `String`  | 고유번호                     |
| `result.content[].name`         | `String`  | 코드 그룹 이름               |
| `result.pageable`               | `Object`  | 페이징 오브젝트              |
| `result.pageable.offset`        | `Number`  | offset                       |
| `result.pageable.pageNumber`    | `Number`  | 페이지 번호 (0부터 시작)     |
| `result.pageable.pageSize`      | `Number`  | 요청한 페이지 당 크기        |
| `result.pageable.paged`         | `Boolean` | 페이징 여부                  |
| `result.pageable.unpaged`       | `Boolean` | 미 페이징 여부               |
| `result.pageable.sort`          | `Object`  | 정렬 정보                    |
| `result.pageable.sort.empty`    | `Boolean` | 정렬 정보 미존재 여부        |
| `result.pageable.sort.unsorted` | `Boolean` | 미정렬 여부                  |
| `result.pageable.sort.sorted`   | `Boolean` | 정렬 여부                    |
| `result.last`                   | `Boolean` | 마지막 페이지 여부           |
| `result.totalPages`             | `Number`  | 페이지 갯수                  |
| `result.totalElements`          | `Number`  | 총 요소 갯수                 |
| `result.first`                  | `Boolean` | 첫 페이지 여부               |
| `result.size`                   | `Number`  | 페이지 당 크기               |
| `result.number`                 | `Number`  | 페이지 번호 (0부터 시작)     |
| `result.sort.empty`             | `Boolean` | 정렬 정보 미존재 여부        |
| `result.sort.unsorted`          | `Boolean` | 미정렬 여부                  |
| `result.sort.sorted`            | `Boolean` | 정렬 여부                    |
| `result.numberOfElements`       | `Number`  | 현재 페이지 요소 갯수        |
| `result.empty`                  | `Boolean` | 현재 페이지 요소 미존재 여부 |

### [공통 코드 그룹 상세 조회 API](http://localhost:9000/docs/index.html#_공통_코드_그룹_상세_조회_api)

#### [Curl request](http://localhost:9000/docs/index.html#_공통_코드_그룹_상세_조회_api_curl_request)

```bash
$ curl 'http://localhost:9000/code/group/92800040-b614-4dc7-9f54-b4af6dcafeaa' -i -X GET
```

#### [HTTP request](http://localhost:9000/docs/index.html#_공통_코드_그룹_상세_조회_api_http_request)

```http
GET /code/group/92800040-b614-4dc7-9f54-b4af6dcafeaa HTTP/1.1
Host: localhost:9000
```

#### [HTTP response](http://localhost:9000/docs/index.html#_공통_코드_그룹_상세_조회_api_http_response)

```http
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
Content-Length: 316

{
  "message" : "SUCCESS",
  "result" : {
    "uuid" : "92800040-b614-4dc7-9f54-b4af6dcafeaa",
    "name" : "da7b1aee-e21c-4462-a595-cb8c18c72d9e_10",
    "description" : "da7b1aee-e21c-4462-a595-cb8c18c72d9e",
    "codes" : [ ],
    "createdAt" : "2023-06-29 19:05:05",
    "updatedAt" : "2023-06-29 19:05:05"
  }
}
```

#### [Path parameters](http://localhost:9000/docs/index.html#_공통_코드_그룹_상세_조회_api_path_parameters)

| Parameter | Description      |
| :-------- | :--------------- |
| `uuid`    | 코드 그룹 식별자 |

#### [Response fields](http://localhost:9000/docs/index.html#_공통_코드_그룹_상세_조회_api_response_fields)

| Path                 | Type     | Description      |
| :------------------- | :------- | :--------------- |
| `message`            | `String` | 시스템 메시지    |
| `result`             | `Object` | 오브젝트         |
| `result.uuid`        | `String` | 코드 그룹 식별자 |
| `result.name`        | `String` | 코드 그룹 이름   |
| `result.description` | `String` | 코드 그룹 설명   |
| `result.codes[]`     | `Array`  | 하위 공통 코드   |
| `result.createdAt`   | `String` | 생성일           |
| `result.updatedAt`   | `String` | 수정일           |

### [공통 코드 그룹 생성 API](http://localhost:9000/docs/index.html#_공통_코드_그룹_생성_api)

#### [Curl request](http://localhost:9000/docs/index.html#_공통_코드_그룹_생성_api_curl_request)

```bash
$ curl 'http://localhost:9000/code/group' -i -X POST \
    -H 'Content-Type: application/json;charset=UTF-8' \
    -d '{
  "name" : "판매 상태",
  "description" : "상품의 판매 상태를 나타내는 코드들의 모임."
}'
```

#### [HTTP request](http://localhost:9000/docs/index.html#_공통_코드_그룹_생성_api_http_request)

```http
POST /code/group HTTP/1.1
Content-Type: application/json;charset=UTF-8
Content-Length: 112
Host: localhost:9000

{
  "name" : "판매 상태",
  "description" : "상품의 판매 상태를 나타내는 코드들의 모임."
}
```

#### [HTTP response](http://localhost:9000/docs/index.html#_공통_코드_그룹_생성_api_http_response)

```http
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
Content-Length: 27

{
  "message" : "SUCCESS"
}
```

#### [Request fields](http://localhost:9000/docs/index.html#_공통_코드_그룹_생성_api_request_fields)

| Path          | Type     | Description        |
| :------------ | :------- | :----------------- |
| `name`        | `String` | 공통코드 그룹명    |
| `description` | `String` | 공통코드 그룹 설명 |

#### [Response fields](http://localhost:9000/docs/index.html#_공통_코드_그룹_생성_api_response_fields)

| Path      | Type     | Description   |
| :-------- | :------- | :------------ |
| `message` | `String` | 시스템 메시지 |

### [공통 코드 그룹 수정 API](http://localhost:9000/docs/index.html#_공통_코드_그룹_수정_api)

#### [Curl request](http://localhost:9000/docs/index.html#_공통_코드_그룹_수정_api_curl_request)

```bash
$ curl 'http://localhost:9000/code/group' -i -X PATCH \
    -H 'Content-Type: application/json;charset=UTF-8' \
    -d '{
  "uuid" : "980538bc-3148-4b3d-b816-be929c2e1993",
  "name" : "가동 상태",
  "description" : null
}'
```

#### [HTTP request](http://localhost:9000/docs/index.html#_공통_코드_그룹_수정_api_http_request)

```http
PATCH /code/group HTTP/1.1
Content-Type: application/json;charset=UTF-8
Content-Length: 105
Host: localhost:9000

{
  "uuid" : "980538bc-3148-4b3d-b816-be929c2e1993",
  "name" : "가동 상태",
  "description" : null
}
```

#### [HTTP response](http://localhost:9000/docs/index.html#_공통_코드_그룹_수정_api_http_response)

```http
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
Content-Length: 27

{
  "message" : "SUCCESS"
}
```

#### [Request fields](http://localhost:9000/docs/index.html#_공통_코드_그룹_수정_api_request_fields)

| Path          | Type     | Description          |
| :------------ | :------- | :------------------- |
| `uuid`        | `String` | 공통코드 그룹 식별자 |
| `name`        | `String` | 공통코드 그룹명      |
| `description` | `Null`   | 공통코드 그룹 설명   |

#### [Response fields](http://localhost:9000/docs/index.html#_공통_코드_그룹_수정_api_response_fields)

| Path      | Type     | Description   |
| :-------- | :------- | :------------ |
| `message` | `String` | 시스템 메시지 |

### [공통 코드 그룹 삭제 API](http://localhost:9000/docs/index.html#_공통_코드_그룹_삭제_api)

#### [Curl request](http://localhost:9000/docs/index.html#_공통_코드_그룹_삭제_api_curl_request)

```bash
$ curl 'http://localhost:9000/code/group/96694b68-eaa1-4591-b738-51fc020ddb9f' -i -X DELETE
```

#### [HTTP request](http://localhost:9000/docs/index.html#_공통_코드_그룹_삭제_api_http_request)

```http
DELETE /code/group/96694b68-eaa1-4591-b738-51fc020ddb9f HTTP/1.1
Host: localhost:9000
```

#### [HTTP response](http://localhost:9000/docs/index.html#_공통_코드_그룹_삭제_api_http_response)

```http
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
Content-Length: 27

{
  "message" : "SUCCESS"
}
```

#### [Path parameters](http://localhost:9000/docs/index.html#_공통_코드_그룹_삭제_api_path_parameters)

| Parameter | Description     |
| :-------- | :-------------- |
| `uuid`    | 공통코드 식별자 |

#### [Response fields](http://localhost:9000/docs/index.html#_공통_코드_그룹_삭제_api_response_fields)

| Path      | Type     | Description   |
| :-------- | :------- | :------------ |
| `message` | `String` | 시스템 메시지 |

