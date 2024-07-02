# Bottle Talk - Backend API 구축 및 ELK Stack을 사용하여 실시간 로그수집 후 시각화 구현 미니 프로젝트

## Description
1. 검색키워드 수집
2. 사용자 액션 로그 수집
3. 에러 로그 수집

## ELK Stack 실행
1. ELK 디렉토리 이동
```shell
$ cd ELK
```
2. docker-compose 실행
```shell
$ docker-compose up
[+] Building 0.0s (0/0)                                              docker-container:server
[+] Running 3/0
 ✔ Container elasticsearch_springboot  Created                                          0.0s
 ✔ Container logstash_springboot       Created                                          0.0s
 ✔ Container kibana_springboot         Created
```
3. docker-compose 컨테이너 목록 조회
```shell
$ docker-compose ps
           Name                         Command               State                                   Ports
NAME                       IMAGE                                                 COMMAND                  SERVICE         CREATED        STATUS         PORTS
elasticsearch_springboot   docker.elastic.co/elasticsearch/elasticsearch:8.3.3   "/bin/tini -- /usr/l…"   elasticsearch   20 hours ago   Up 2 minutes   0.0.0.0:9200->9200/tcp, 9300/tcp
kibana_springboot          docker.elastic.co/kibana/kibana:8.3.3                 "/bin/tini -- /usr/l…"   kibana          20 hours ago   Up 2 minutes   0.0.0.0:5601->5601/tcp
logstash_springboot        docker.elastic.co/logstash/logstash:8.3.3             "/usr/local/bin/dock…"   logstash        20 hours ago   Up 2 minutes   0.0.0.0:5044->5044/tcp, 0.0.0.0:5050->5050/tcp, 0.0.0.0:9600->9600/tcp, 0.0.0.0:5050->5050/udp
```
4. ElastickSearch 확인
```shell
$ open http://localhost:9200

{
  "name" : "5849da363afd",
  "cluster_name" : "docker-cluster",
  "cluster_uuid" : "KdoChtChTNKlVoKzKrExlA",
  "version" : {
    "number" : "8.3.3",
    "build_flavor" : "default",
    "build_type" : "docker",
    "build_hash" : "801fed82df74dbe537f89b71b098ccaff88d2c56",
    "build_date" : "2022-07-23T19:30:09.227964828Z",
    "build_snapshot" : false,
    "lucene_version" : "9.2.0",
    "minimum_wire_compatibility_version" : "7.17.0",
    "minimum_index_compatibility_version" : "7.0.0"
  },
  "tagline" : "You Know, for Search"
}
```
5. Kibana 확인
```shell
$ open http://localhost:5601/app/kibana
```

## Backend API 실행
```shell
$ java -version
$ gradle --version
$ gradle bootRun
```
위스키 검색하기

| 메서드 | URL                                                    | 설명             |
|-----|--------------------------------------------------------|----------------|
| GET | http://localhost:8080/v1/api/products                  | 전체 위스키정보를 조회   |
| GET | http://localhost:8080/v1/api/products/{id}             | 특정 위스키정보를 조회   |
| GET | http://localhost:8080/v1/api/products?search={keyword} | 키워드로 위스키목록을 조회 |

