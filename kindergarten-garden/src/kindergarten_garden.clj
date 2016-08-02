(ns kindergarten-garden
  (:require [clojure.string :as string]))


(def plants {\G :grass, \C :clover, \R :radishes , \V :violets})

(def kids
  {:alice 0, :bob 1, :charlie 2, :david 3, :eve 4, :fred 5, :ginny 6, :harriet 7,
   :ileana 8, :joseph 9, :kincaid 10, :larry 11})

(defn pairs [string]
  (map #(string/join %)
       (partition 2 (-> string
                        (string/split #"\s")
                        (string/join)))))

(defn combine [string]
  (let [c (pairs string)
        middle (/ (count c) 2)]
    (map #(str (nth c %) (nth c (+ middle %)))
         (range middle))))


(defn garden
  ([string]
   (zipmap (sort (keys kids))
           (map #(map plants %) (combine string))))
  ([string names]
   (zipmap (sort (map keyword (map string/lower-case names)))
           (map #(map plants %) (combine string)))))


