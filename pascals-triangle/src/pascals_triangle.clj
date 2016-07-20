(ns pascals-triangle)

(def triangle (iterate (fn [i]
                         (map #(reduce +' %)
                              (partition 2 1 (concat [0] i [0]))))
                       [1]))
(defn row [n]
  (nth triangle (dec n)))

