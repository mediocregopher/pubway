(ns pubway.process
  (:require [clojure.string :as str])
  (:require [pubway.pubsub :as pubsub]))

(defn decode-pub [data]
  (if (= 2 (count data))
    (pubsub/do-pub (nth data 0) (nth data 1))
    "badargs" ))

(defn decode-sub [data]
  (if (= 1 (count data))
    (pubsub/sub-listen (nth data 0))
    "badargs" ))

(defn decode [data]
  (case (first data)
    "pub" (decode-pub (rest data))
    "sub" (decode-sub (rest data))
    "badcommand"))

(defn process-data [data]
  (let [processed (str/split data #" " 3) ]
      (decode processed)))

