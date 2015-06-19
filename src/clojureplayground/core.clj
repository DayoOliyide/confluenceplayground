(ns clojureplayground.core)



(comment
  (use 'clj-kafka.producer)
  (require '[org.httpkit.client :as http])
  (require '[abracad.avro :as avro])
  (require '[cheshire.core :as json])

  (def schema {:type :record
               :name "UserRecord"
               :fields [{:name "first-name" :type :string}
                        {:name "last-name" :type :string}]})

  (def avro-schema (avro/parse-schema schema))

  ;;Send a request to Kafka-Rest
  @(http/post "http://localhost:8082/topics/kafka-rest-messages"
              {:content-type "application/vnd.kafka.avro.v1+json"
               :accept ["application/vnd.kafka.v1+json" "application/vnd.kafka+json" "application/json"]
               :body (json/generate-string
                      {:value_schema schema
                       :records [{:first-name :Dayo :last-name :Oliyide}
                                 {:first-name :Luke :last-name :Skywalker}]})})


  @(http/post "http://localhost:8082/topics/kafka-rest-messages"
              {:content-type "application/vnd.kafka.avro.v1+json"
               :accept ["application/vnd.kafka.v1+json" "application/vnd.kafka+json" "application/json"]
               :body
               (json/generate-string {:value_schema "{\"name\" :\"first-name\" , \"type\": \"string\"}"
                                      :records [ {:first-name "Dayo"} {:first-name "Luke"}]})})

  (->
   @(http/get "http://localhost:8082/topics/"
              {:accept ["application/vnd.kafka.v1+json" "application/vnd.kafka+json" "application/json"]})
   clojure.pprint/pprint)

  )
