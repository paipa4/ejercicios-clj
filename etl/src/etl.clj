(ns etl
  (:require [clojure.string :as string]))

(defn expand-kv [kv]
  (zipmap (map string/lower-case (last kv))
          (repeat (first kv))))


(defn transform [hsh]
  (loop [-hc hsh
         result {}]
    (if (empty? -hc)
      result
      (recur (rest -hc)
             (merge result (expand-kv (first -hc)))))))
