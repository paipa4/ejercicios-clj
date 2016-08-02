(ns sum-of-multiples)

(defn- is-multiple? [x coll]
  (some zero? (map #(mod x %) coll)))

(defn sum-of-multiples
  ([a] (sum-of-multiples [3 5] a))
  ([b a] (reduce + (filter #(is-multiple? % b)
                           (range 1 a)))))


