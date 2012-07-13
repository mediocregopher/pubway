(ns pubway.pubsub)

(defn now [] (new java.util.Date))

(def master (agent {}))

(defn append-promise [map sub prom]
  (let [currsubmap (map sub {})]
    (assoc map sub 
      (assoc currsubmap
        :promises (conj (currsubmap :promises (list)) prom)
        :tsmod now))))
        
(defn deliver-promises [map sub value]
  (do
    (doseq [prom ((map sub {}) :promises (list))]
       (deliver prom value))
    (dissoc map sub)))

(defn sub-listen [sub]
  (let [prom (promise)]
    (send master append-promise sub prom)
    @prom))

(defn do-pub [sub value]
  (do
    (send master deliver-promises sub value)
    "ok"))
