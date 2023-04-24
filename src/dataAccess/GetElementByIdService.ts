import { type SelbriDTO } from "../DTO/SelbriDTO.js";
import { SelbriDAO } from "../DAO/SelbriDAO.js";

export class GetElementByIdService {
  constructor(readonly selbriDAO = SelbriDAO) {}

  async getElementById(id: string): Promise<SelbriDTO | null> {
    const selbri = await this.selbriDAO.findById(id);
    return selbri as SelbriDTO | null;
  }
}
