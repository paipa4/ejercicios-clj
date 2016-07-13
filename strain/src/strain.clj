(ns strain)

(defn retain [fun coll]
  (loop [coll coll
         result []]
    (if (empty? coll)
       result
      (if (fun (first coll))
        (recur (rest coll)
               (conj result (first coll)))
        (recur (rest coll)
                result)))))

(defn discard [fun coll]
  (retain (complement fun) coll))
