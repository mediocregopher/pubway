(ns pubway.pubsub)

(def master (agent {}))

(defn append-promise [map sub promise]
  (assoc map sub
    (conj
      (map sub (list))
       promise)))

(defn deliver-promises [map sub value]
  (do
    (doseq [promise (map sub (list))]
       (println promise value))
    (dissoc map sub)))
