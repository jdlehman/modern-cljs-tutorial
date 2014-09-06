(ns modern-cljs.modern
  (:require [clojure.browser.repl :as repl]))

(repl/connect "http://localhost:9000/repl")

(.write js/document "Hello, CLojureScript!")
