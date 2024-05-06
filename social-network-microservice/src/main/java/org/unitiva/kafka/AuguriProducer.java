package org.unitiva.kafka;

import java.util.List;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.unitiva.bean.Utente;
import org.unitiva.service.UtenteService;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AuguriProducer {

    UtenteService utenteService = new UtenteService();

    @Inject
    @Channel("auguri-out")
    Emitter<String> emitter;

    //@Scheduled(cron = "{cron.expr}")

    @Scheduled(every = "60s")

    public void sendAuguriKafka (){
      //  emitter.send("AUGURI  per il tuo compleanno!!!");            
        List<Utente> listaCompleanniUtenti = utenteService.findCompleanniOggi();

        for (Utente utente : listaCompleanniUtenti){
          emitter.send("AUGURI "+utente.getNome()+" "+utente.getCognome()+" per il tuo compleanno!!!");                         
         }
    }
        
}

