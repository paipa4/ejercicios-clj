(ns binary-search)

(defn middle [vect]
  (quot (count vect) 2))


(defn search-for [item coll]
  (cond
    (> (count coll) 1) (let [m-index (middle coll)
                             m-item (nth coll m-index)]
                         (cond
                           (> item m-item) (+ (search-for item
                                                          (subvec (apply vector coll) (inc m-index)))
                                              m-index
                                              1)
                           (< item m-item) (search-for item (subvec coll 0 m-index))
                           (= item m-item) m-index))
    (or (empty? coll)
        (and (= (count coll) 1) (not= (first coll) item))) (throw (Exception. "not found"))
    :else 0))


