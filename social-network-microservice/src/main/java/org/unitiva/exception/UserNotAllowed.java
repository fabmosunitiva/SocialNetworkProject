package org.unitiva.exception;

public class UserNotAllowed extends RuntimeException {
        private final Long id;
        private final String ruolo;

        public UserNotAllowed(Long id, String ruolo) {
          super("Utente id: "+ id + " non ha il permesso con ruolo: " + ruolo);
          this.id = id;
          this.ruolo = ruolo;
        }
        
        public Long getId() {
            return id;
        }

        public String getRuolo() {
          return ruolo;
        }
}
