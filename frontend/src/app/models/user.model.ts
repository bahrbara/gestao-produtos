export class User {
    idClient?: string;
    name?: string;
    cpf?: string;
    birthdate?: Date;

    constructor(user) {
        this.idClient = user.idClient || '',
        this.name = user.name || '';
        this.cpf = user.cpf || '';
        this.birthdate = user.birthdate || '';
    }
}
