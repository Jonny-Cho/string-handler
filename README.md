# string-handler

## 실행방법

```
git clone https://github.com/Jonny-Cho/data-processor.git
./gradlew bootRun
or
./gradlew build
java -jar ./build/libs/dataprocessor-0.0.1-SNAPSHOT.jar
```

## Swagger
http://localhost:8080/swagger-ui/index.html

## 개발환경
* Java8
* Spring Boot 2.6.4
* Junit5
* Jsoup
* Swagger

## 요구사항

1. URL 입력을 하면 그 링크 안에있는 모든 HTML코드를 불러온다.
2. 노출유형
    * 노출 유형이 HTML 일 경우는 태그를 제거한다
        * `<div>abc</div> -> abc`
    * 노출 유형이 TEXT 일 경우에는 모든 텍스트 포함
        * `<div>abc</div> -> <div>abc</div>`
3. 영어, 숫자만 출력
    * 결과 데이터는 영어와 숫자로만 구성된 데이터만 출력한다
4. 오름차순 정렬
    * 영어 : AaBbCcDd ... Zz
    * 숫자 : 0123456789
5. 교차출력
    * 영어숫자영어숫자
    * 더이상 출력될 숫자 또는 영어가 없을경우 남아있는 문자열 그대로 출력
6. 출력묶음단위
    * 사용자가 입력한 자연수의 묶음 단위를 기준으로 몫과 나머지를 구하여 노출
    * 예) ‘A0a1B2b3’, 출력 묶음 단위 3인경우
        * 몫 ‘A0a1B2’
        * 나머지 ‘b3’
    
