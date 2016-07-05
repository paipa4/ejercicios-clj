(ns gigasecond
  (:import [java.util Calendar]
           [java.text SimpleDateFormat]))


(defn date [calendar]
  (vector (.get calendar (Calendar/YEAR))
          (inc (.get calendar (Calendar/MONTH)))
          (.get calendar (Calendar/DATE))))

(defn from [year month day]
  (let [calendar (Calendar/getInstance)]
    (.set calendar year (dec month) day)
    (.add calendar (Calendar/SECOND) 1000000000)
    (date calendar)))

