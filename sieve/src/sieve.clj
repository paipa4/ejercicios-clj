(ns sieve)

(defn no-multiple [a coll]
  (filter #(or (= % a)
               (not= 0 (mod % a)))
          coll))

(defn sieve [limit]
  (loop [coll (range 2 (inc limit))
         index 0]
    (if (< limit (Math/pow (nth coll index) 2))
      coll
      (recur (no-multiple (nth coll index) coll)
             (inc index)))))
