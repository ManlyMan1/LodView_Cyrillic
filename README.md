# LodView
LodView is a Java web application based on Spring and Jena, it's a tool able to offer a W3C standard compliant IRI dereferenciation. LodView, in conjunction with a SPARQL endpoint, allows you to publish RDF data according to all defined standards for Linked Open Data.

LodView is easy to configure and deploy for any developer and it dramatically improves the end user’s experience in accessing HTML based representations of RDF resources.

## Cyrillic character support
In this fork of the LodView project we've implemented some improvements for cyrillic characters support and added some UI improvements.

## Installation instruction
See [the wiki page](https://github.com/dvcama/LodView/wiki).

## Some interesting features
##### Content negotiation and serialization
LodView allows you to publish RDF data offering a lot of different serializations. It handles content negotiation requests with or without 303 redirections: at the same IRI you can fully access different versions of the resource (HTML, turtle, n-triples, json, json-ld, and many more) or you can set a suffix useful to redirect some requests to an HTML representation of the resource (eg. `http://example.com/resource/aaaa/html`). You can also override content negotiation features adding the 'output' parameter to the URL and specifying which serialization format you want to access, e.g. `http://example.com?output=application/ld-json`).

From LodView v1.2.0 you can also use prefixes (e.g. `http://example.com/page/aaaa`) or set a full "Pubby compliant" redirection strategy (e.g. `http://example.com/page/aaaa`, `http://example.com/data/aaaa.ntriples`, etc.) to easily update to LodView but still offering the same URLs to the users.

##### Internationalization and content language
Available languages: English, Italian, French, Slovak, Galician and Dutch.

LodView interface uses a very few words (labels and system messages) all managed with a language configuration file. It's able to use the client locale to manage not only the interface language but also the RDF literal values for a full i18n experience. You also have the possibility to override your default locale using 'locale' parameter, e.g. `http://example.com?locale=fr`.

We will appreciate any help in translating LodView, please commit your translation using GitHub or send us the [translation file](https://github.com/dvcama/LodView/blob/master/src/main/resources/messages_en.properties).

Special thanks to Jana Ivanová for the Slovak translation, to Miguel Solla for the Galician translation and to Roland Cornelissen for the Dutch translation.

##### Information about used properties
LodView provides info about every property found in the resource, just hover on the property to get an "info tooltip" that shows label and comment from the referring ontology (according to the locale of the client). See also [how to populate info tooltip](https://github.com/dvcama/LodView/wiki/how-to%3A-populate-info-tooltip).

##### Object properties
In order to help humans understand the meaning of a resource, LodView shows the label of every object property it has found according to the locale of the client.

##### Blank nodes management
We don't like blank nodes, but they are used sometimes so we have managed them as an actual part of the resource; they contain information that doesn't belong to any other resource so LodView shows them in the main resource page nesting their values in sub-boxes which saves the user further clicks and contextualizes data more effectively.

##### Inverse relations management
Inverse relations are an interesting descriptive part of a resource. Very often inverse relations are as valuable and informative as direct relations, and sometimes there are too many of them to be shown all in one go on the HTML page. LodView collects the inverse resources showing them in collapsed boxes; it also provides information about the used inverse properties and the total count of elements that share them without transferring all the data at once but using light on-demand Ajax calls instead.

##### Colors and user experience
LodView is beautiful and colorful: you can let it randomize the colors of the interface or set your own colors or even bind classes to specific colors to make all "people" orange and all "organizations" green.

##### Resource widget
LodView provides (and will provide) various widgets for displaying multimedia contents, thesaurus hierarchies, external connected resources and geographical information.

##### Image widget
Easy access to the image referenced in a resource, e.g. [British museum](http://lodview.it/lodview/?IRI=http%3A%2F%2Fcollection.britishmuseum.org%2Fid%2Fobject%2FYCA62958&sparql=http%3A%2F%2Fcollection.britishmuseum.org%2Fsparql&prefix=http%3A%2F%2Fcollection.britishmuseum.org%2Fid%2Fobject%2F).

##### Video and audio widget
Players for videos and even audio files are embedded in the resource page, e.g. [linked jazz](http://lodview.it/lodview/?IRI=http%3A%2F%2Flinkedjazz.org%2Fresource%2FMary_Lou_Williams&sparql=https%3A%2F%2Flinkedjazz.org%2Fsparql%2Fselect&prefix=http%3A%2F%2Flinkedjazz.org%2Fresource%2F).

##### Linked LOD resources widget
To make the context of the viewed resourced even more understandable and to prove the power of the linked data cloud, all connected resources (e.g. `sameAs`) are automatically shown with their title, an image or a map, and an abstract, e.g. [dati.camera](http://lodview.it/lodview/?IRI=http%3A%2F%2Fdati.camera.it%2Focd%2Fpersona.rdf%2Fp4230&sparql=http%3A%2F%2Fdati.camera.it%2Fsparql&prefix=http%3A%2F%2Fdati.camera.it%2Focd%2F).

##### Map representation widget
Geographical information is shown as points on a map (thanks to the OSM project), e.g. [geonames](http://lodview.it/lodview/?IRI=http%3A%2F%2Fsws.geonames.org%2F6471849%2F&sparql=%3C%3E&prefix=http%3A%2F%2Fsws.geonames.org%2F).

**TODO**: manage shape representation.

##### Hierarchy widget
**TODO**: develop a widget which is able to represent hierarchical relations (e.g. thesauri, family trees or taxonomies).

##### SPARQL URL handler
Because we want the SPARQL endpoint URL to be easy to deduce from a resource's IRI, LodView manages calls to `http://data.yourdomain.com/sparql` redirecting clients to the SPARQL endpoint real URL or proxying it for an even easier access (proxy feature is still under development). This particular feature simplifies server configuration and supports client's discovery capabilities.

