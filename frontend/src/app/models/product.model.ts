export class Product {
    idProduct?: string;
    name?: string;
    sku?: string;
    description?: string;
    price?: number;
    amount?: number;

    constructor(product) {
        this.idProduct = product.idProduct || '',
        this.name = product.name || '';
        this.sku = product.sku || '';
        this.description = product.description || '';
        this.price = product.price || '';
        this.amount = product.amount || '';
    }
}