import { Contract, type Unpromised, bound, serialize } from "cdd-ts";
import { SaveElementService } from "../../src/dataAccess/SaveElementService.js";
import { SelbriTestData } from "../../testdata/SelbriTestData.js";
import { type EnvironmentManipulatorType } from "cdd-ts/dist/src/types/EnvironmentManipulatorType.js";
import { mongooseInstance } from "../../src/DAO/mongooseInstance.js";
import { execSync } from "child_process";

export const SaveElementServiceContractParties = [bound(SaveElementService)];

const UTF_8 = "utf-8";
const RESTART_MONGO = "docker-compose restart";
const STOP_MONGO = "docker-compose stop";

class DatabaseUpper implements EnvironmentManipulatorType {
  async setUp(): Promise<void> {
    const output = execSync(RESTART_MONGO, { encoding: UTF_8 });
    console.log(output);
  }

  tearDown(): void {}
}

class DatabaseDowner implements EnvironmentManipulatorType {
  async setUp(): Promise<void> {
    await mongooseInstance.disconnect();
    const output = execSync(STOP_MONGO, { encoding: UTF_8 });
    console.log(output);
  }

  tearDown(): void {}
}

export const SaveElementServiceContract = new Contract<
  Unpromised<SaveElementService["saveElement"]>
>()
  .setTitle("Saves a selbri")
  .when("the database is up", new DatabaseUpper())
  .ifCalledWith(() => SelbriTestData.default)
  .thenReturn("returns the saved data", {
    default: () => SelbriTestData.default,
    check: (dto) => {
      if (serialize(Object.keys(dto)) !== serialize(["id", "representation"]))
        return dto;
      if (dto.representation !== SelbriTestData.default.representation)
        return dto;
      return undefined;
    },
  })
  .when("the database is down", new DatabaseDowner())
  .ifCalledWith(() => SelbriTestData.default)
  .thenThrow(
    "Throws an exception",
    "MongoNotConnectedError: Client must be connected before running operations"
  );
