(ns pubway.process
  (:require [clojure.string :as str]))

(defn decode-pub [data]
  (if (= 2 (count data))
    "ok"
    "badargs" ))

(defn decode-sub [data]
  (if (= 1 (count data))
    "ok"
    "badargs" ))

(defn decode [data]
  (case (first data)
    "pub" (decode-pub (rest data))
    "sub" (decode-sub (rest data))
    "badcommand"))

(defn process-data [data]
  (let [processed (str/split data #" " 3) ]
      (decode processed)))

