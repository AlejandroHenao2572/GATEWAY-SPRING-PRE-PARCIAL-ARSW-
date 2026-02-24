file:///C:/Users/aleja/OneDrive/Desktop/7%20SEMESTRE/ARSW/First-term/PREPARCIAL/GATEWAY-SPRING-PRE-PARCIAL-ARSW-/src/main/java/com/parcial/arsw/controllers/ProductController.java
empty definition using pc, found symbol in pc: 
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 458
uri: file:///C:/Users/aleja/OneDrive/Desktop/7%20SEMESTRE/ARSW/First-term/PREPARCIAL/GATEWAY-SPRING-PRE-PARCIAL-ARSW-/src/main/java/com/parcial/arsw/controllers/ProductController.java
text:
```scala
package com.parcial.arsw.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.parcial.arsw.model.Product;
import com.parcial.arsw.services.ProductService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService@@ service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product p) {
        Product created = service.create(p);
        return ResponseEntity.created(URI.create("/api/products/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product p) {
        return service.update(id, p)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: 