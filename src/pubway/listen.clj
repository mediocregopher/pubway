(ns pubway.listen
  (:use [ring.adapter.jetty :only [run-jetty]])
  (:require [pubway.process :as process]))


(defn app [req]                                
  (do
    (let [response (process/process-data (slurp (req :body)))]
      {:status 200                                
         :headers {"Content-Type" "text/plain"}
         :body response})))
                                
                                
(defn -mainExt [portString]                                
  (let [port (Integer/parseInt portString)]
    (run-jetty app {:port port})))                                
                                
(defn -main                                
    ([]     (-mainExt (System/getenv "PORT")))
    ([port] (-mainExt port)))    
