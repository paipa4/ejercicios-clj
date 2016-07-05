(ns bob
  (:require [clojure.string :as string]))

(defn response-for [algo]
  (if (re-seq #"^([A-Z][^a-z]+|[^a-z]+[A-Z])+$" algo)
    "Whoa, chill out!"
    (if (= \? (last algo))
      "Sure."
      (if (= ""(string/trim algo))
        "Fine. Be that way!"
        (if (= \? (last algo))
          "Sure."
          "Whatever.")))))




