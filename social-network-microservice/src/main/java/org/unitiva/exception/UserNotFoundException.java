package org.unitiva.exception;

public class UserNotFoundException extends RuntimeException {
        private final Long id;

        public UserNotFoundException(Long id) {
          super("Utente non trovato con id: "+ id);
          this.id = id;
        }
        
        public Long getId() {
            return id;
        }
}
