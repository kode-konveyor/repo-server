import { SelbriDAO } from "../DAO/SelbriDAO.js";
import { type SelbriDTO } from "../DTO/SelbriDTO.js";

export class SaveElementService {
  constructor(readonly SelbriConstructor = SelbriDAO) {}

  async saveElement(element: SelbriDTO): Promise<SelbriDTO> {
    const saved = new this.SelbriConstructor(element);
    await saved.save();
    return { id: saved.id, representation: saved.representation as string };
  }
}
