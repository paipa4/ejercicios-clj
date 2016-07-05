(ns grade-school
   (:require [clojure.string :as string]))

(defn grade [school grad]
  (or (get school grad) []))

(defn add [school nam grad]
  (update school grad #(conj (or % []) nam)))


(defn sorted [mapa]
  (into (sorted-map)
        (map #(vector (first %)
                      (sort (last %))) mapa)))
