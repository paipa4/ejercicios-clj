(ns largest-series-product
  (:require [clojure.string :as string]))

(defn mult [collection]
  (apply * collection))

(defn divide-number [n string]
(partition n 1 (map #(Integer. (str %)) (apply list string))))

(defn largest-product [n string]
  (let [coll (divide-number n string)]
    (if (or (= 1 n) (> n (count string)))
      (throw (Exception.))
       (if (or (= 1 n)
      (if (zero? n)
        1
        (apply max (map mult coll))))))

