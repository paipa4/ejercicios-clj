(ns phone-number
  (:require [clojure.string :as string]))


(defn split
  "Validates the phone number and splits it"
  [phone]
  (rest
    (re-find #"^1?\(?(\d{3})\)?\D?(\d{3})\D?(\d{4})$" phone)))

(defn number
  "Cleans phone number"
  [phone]
  (let [phone-parts (split phone)]
    (if (empty? phone-parts)
      "0000000000"
      (string/join phone-parts))))

(defn area-code
  "Returns the area code of a given phone number"
  [phone]
  (first (split phone)))

(defn pretty-print
  "Formats a phone number"
  [phone]
  (let [[area n1 n2] (split phone)]
    (str "(" area ") " n1 "-" n2)))

