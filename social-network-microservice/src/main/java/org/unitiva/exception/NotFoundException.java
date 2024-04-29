package org.unitiva.exception;

public class NotFoundException extends RuntimeException {
        private final Long id;

        public NotFoundException(Long id,String message) {
          super(message);
          this.id = id;
        }
        
        public Long getId() {
            return id;
        }
}
