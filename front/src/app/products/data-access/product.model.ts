export interface Product {
    id: number;
    code: string;
    name: string;
    description: string;
    image: string;
    category: string;
    price: number;
    quantity: number;
    internalreference: string;
    shellid: number;
    inventorystatus: "INSTOCK" | "LOWSTOCK" | "OUTOFSTOCK";
    rating: number;
    createdAt: number;
    updatedAt: number;
}