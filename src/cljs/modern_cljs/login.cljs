(ns modern-cljs.login
  (:use [domina :only [by-id value]]))

;; define function to attach to form submission
(defn validate-form []
  ;; get email and password from html
  (let [email (by-id "email")
        password (by-id "password")]
    (if (and (> (count (value email)) 0)
             (> (count (value password)) 0))
      true
      (do (js/alert "Please, complete the form!")
          false))))

;; define function to attach validate-form to onsubmit even of form
(defn ^:export init []
  ;; verify that js/document exists and has getElementById property
  (if (and js/document
           (.-getElementById js/document))
    ;; get loginForm by element id and set its onsubmit property
    ;; to validate-form function
    (let [login-form (.getElementById js/document "loginForm")]
      (set! (.-onsubmit login-form) validate-form))))
