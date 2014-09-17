(defproject modern-cljs "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  ;; CLJ and CLJS source code path
  :source-paths ["src/clj" "src/cljs"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2197"]
                 [domina "1.0.3-SNAPSHOT"]
                 [compojure "1.1.6"]]

  :plugins [[lein-cljsbuild "1.0.3"]
            [lein-ring "0.8.8"]]

  ;; ring config
  :ring {:handler modern-cljs.core/handler}

  ;; cljsbuild options config
  :cljsbuild {
    :builds [{;; cljs source code path
              :source-paths ["src/cljs"]
              ;; google closure (cls) options config
              :compiler {;; cls generated js script filename
                         :output-to "resources/public/js/modern.js"
                         ;; minimal js optimization directive
                         :optimizations :whitespace
                         ;; generated js code prettyfication
                         :pretty-print true}}]})
