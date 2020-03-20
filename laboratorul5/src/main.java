public class main {
    public static void main(String Args[]) {
        main app = new main();
        app.testCreateSave();
        app.testLoadView();
    }

    public void testCreateSave() {
        Catalog catalog = new Catalog("Java Resources", "d:/java/catalog.ser");
        Document doc = new Document("java1", "Java Course 1", "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add("doc");
        CatalogUtil.save(catalog);
    }

    private void testLoadView() {
        Catalog catalog = CatalogUtil.load("d:/java/catalog.ser");
        Document doc = catalog.findById("java1");
        CatalogUtil.view(doc);
    }


}
