(ns etl
  (:require [clojure.string :as string]))

(defn expand-kv [[k v]]
  (zipmap (map string/lower-case v)
          (repeat k)))


(defn transform [hsh]
  (loop [-hc hsh
         result {}]
    (if (empty? -hc)
      result
      (recur (rest -hc)
             (merge result (expand-kv (first -hc)))))))
