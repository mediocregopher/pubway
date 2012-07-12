(ns pubway.listen
  (:use [ring.adapter.jetty :only [run-jetty]])
  (:require [clj-json.core :as json]))

(defn process-data [data]
  (let [processed (re-seq #"$([^&=]+)=([^=&]+)" data)]
  (if (= nil processed)
    data
    (last (first processed)))))

(defn app [req]                                
  (do
    (println (process-data (slurp (req :body))))
    {:status 200                                
       :headers {"Content-Type" "text/plain"}
       :body "Hello from Clojure!\n"}))
                                
                                
(defn -mainExt [portString]                                
  (let [port (Integer/parseInt portString)]
    (run-jetty app {:port port})))                                
                                
(defn -main                                
    ([]     (-mainExt (System/getenv "PORT")))
    ([port] (-mainExt port)))    
