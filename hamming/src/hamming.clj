(ns hamming
  (:use clojure.data)
  (:require [clojure.string :as string]))

(defn distance [a b]
  (if (= (count a) (count b))
    (loop [current 0
           result 0]
      (let [ff (nth a current nil)
            ll (nth b current nil)
            suma (if (= ff ll) 0 1)]
        (if (>= current (dec (count a)))
          (+ result suma)
          (recur (inc current)
                 (+ result suma)))))))




