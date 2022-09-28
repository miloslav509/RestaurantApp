export class Item implements ItemInterface {
    public id?: number;
    public name: string;
    public price: number;
    public category: CategoryIntegface;

    constructor(item: ItemInterface) {
        this.id = item.id;
        this.name = item.name;
        this.price = item.price;
        this.category = item.category;
    }
}

interface ItemInterface {
    id?: number;
    name: string;
    price: number;
    category: CategoryIntegface
}

export interface CategoryIntegface {
    id?: number;
    name?: string;
}

export interface UserInterface {
    id?: number;
    username: string;
    password: string;
}

export enum Page {
    prev,
    next
}