import type express from "express";
import { HTTP_OK } from "../Constants.js";
import { GetElementByIdService } from "../dataAccess/GetElementByIdService.js";

export class GetElementControllerService {
  constructor(
    readonly getElementById = GetElementByIdService.prototype.getElementById
  ) {}

  getElementController(req: express.Request, res: express.Response): void {
    res.status(HTTP_OK).send(this.getElementById(req.body));
  }
}
