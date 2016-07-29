(ns accumulate)

(defn accumulate [fun collection]
  (loop [coll collection
         result [] ]
    (if (empty? coll)
      result
      (recur (rest coll)
             (conj result (fun (first coll)))))))

