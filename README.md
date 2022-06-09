## simple_realworld

### Info
- 간단한 게시글 & 댓글 조회 프로젝트
- 주특기 1주차 개인 과제 
- url : http://34.197.218.191/articles
- 기술 스택 : Spring Boot, JPA(Hibernate), AWS EC2(배포 환경), AWS RDS(DB, MySQL Server)

<br>

### 기능 및 API SPEC

- 다음을 확인 : https://github.com/SangHoonly/simple_realworld/wiki/API-Spec

<br> <br>

- 엔드포인트 

1. 전체 게시글 조회 : `GET /articles`
2. 특정 게시글 조회 : `GET /articles/{article-id}`
3. 게시글 생성 : `POST /articles`
4. 특정 게시글 수정 : `PUT /articles/{article-id}`
5. 특정 게시글 조회 : `DELETE /articles/{article-id}`
6. 특정 게시글의 전체 댓글 목록 조회 : `GET /articles/{article-id}/comments`
7. 댓글 생성 : `POST /articles/{article-id}/comments`
8. 특정 게시글 수정 : `PUT /articles/{article-id}/comments/{comment-id}`
9. 특정 게시글 삭제 : `DELETE /articles/{article-id}/comments/{comment-id}`

<br>

- 생성, 수정 시 요청 payload (JSON)
``` json
{
   "title" : "응애 나 애기 게시글",
   "author" : "Big Baby",
   "body" : "응애",
}
```
<br>

2. 댓글 생성 & 수정 <br>

``` json
{
   "body" : "응애 나 애기 댓글",
}
```

<br> <br>




- 응답 데이터 형식(JSON)

<br>

1. 게시글 하나 <br>


``` json

{
"article" : {
   "id" : 100,
   "title" : "힘의 차이가 느껴지십니까",
   "author" : "Lee Jerry",
   "body" : "ㅈㄱㄴ",
   "created_at" : "2022-06-03T12:25:16.637Z",
   "updated_at" : "2022-06-03T12:25:16.637Z"
  }
}
```
<br>
2. 게시글 목록<br>

``` json

{ 
"articles" : [{
   "id" : 100,
   "title" : "힘의 차이가 느껴지십니까",
   "author" : "Lee Jerry",
   "body" : "ㅈㄱㄴ",
   "created_at" : "2022-06-03T12:25:16.637Z",
   "updated_at" : "2022-06-03T12:25:16.637Z"
  }, {
   "id" : 101,
   "title" : "안느껴지는데요",
   "author" : "Lee Jerry",
   "body" : "헤헷",
   "created_at" : "2022-06-04T12:25:16.637Z",
   "updated_at" : "2022-06-04T12:25:16.637Z"
  }]
}
```
<br>

3. 게시물의 전체 댓글 조회<br>

``` json
{ 
"comments" : [{
   "id" : 1,
   "body" : "어쩔 티비",
   "created_at" : "2022-06-03T12:25:16.637Z",
   "updated_at" : "2022-06-03T12:25:16.637Z"
  }, {
   "id" : 2,
   "body" : "저쩔 냉장고",
   "created_at" : "2022-06-04T12:25:16.637Z",
   "updated_at" : "2022-06-04T12:25:16.637Z"
  }]
}
```
<br>

4. 댓글 하나 조회 <br>


``` json
{
   "id" : 1,
   "body" : "어쩔 티비",
   "created_at" : "2022-06-03T12:25:16.637Z",
   "updated_at" : "2022-06-03T12:25:16.637Z"
}
```
