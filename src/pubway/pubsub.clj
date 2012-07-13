(ns pubway.pubsub)

(def master (atom nil))

(defn watch-master [sub prom]
  (add-watch master (rand)
    (partial
      (fn [prom s key ref _old new]
        (if (= s (first new))
          (do (remove-watch ref key) (deliver prom (last new)))
          :donothing))
      prom sub)))

(defn sub-listen [sub]
  (let [prom (promise)]
    (watch-master sub prom)
    @prom))

(defn do-pub [sub value]
  (do
    (swap! master (fn [_] [sub value]))
    "ok"))
