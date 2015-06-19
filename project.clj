(defproject clojureplayground "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [cheshire "5.5.0"]
                 [clj-kafka "0.3.1"]
                 [http-kit "2.1.18"]
                 [com.damballa/abracad "0.4.12"]
                 [io.confluent/kafka-avro-serializer "1.0"]]
  :repositories [["Confluent" "http://packages.confluent.io/maven/"]])


